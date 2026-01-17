package dev.docker;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificates;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.HostConfig;
import com.spotify.docker.client.messages.PortBinding;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // 도커 리눅스 호스트와 동일한 곳이면, 유닉스 소켓 사용 가능
    private static final String DOCKER_IP_UNIX = "unix://var/run/docker.sock";

    private static final String DOCKER_HTTP_IP = "http://192.168.0.100:2375";
    private static final String DOCKER_HTTPS_IP = "https://192.168.0.100:2376";

    public static void main(String[] args) throws DockerException, InterruptedException, DockerCertificateException {
        dockerInfo();
//        httpsInfo();
//        nginxContainer();
    }

    /**
     * 80번 포트 개방 nginx 컨테이너 생성 예제,
     * docker run -d -p 0.0.0.0:10080:80 --name mynginx nginx 와 동일한 코드
     */
    private static void nginxContainer() throws DockerException, InterruptedException {
        DockerClient dc = DefaultDockerClient.builder().uri(DOCKER_HTTP_IP).build();

        // 포트 바인딩 생성
        List<PortBinding> hostPort = new ArrayList<>();
        hostPort.add(PortBinding.of("0.0.0.0", "10080"));
        Map<String, List<PortBinding>> portBindings = new HashMap<>();
        portBindings.put("80/tcp", hostPort);
        final HostConfig hostConfig = HostConfig.builder()
                .portBindings(portBindings)
                .build();

        // 컨테이너 생성
        ContainerCreation container = dc.createContainer(ContainerConfig.builder()
                .image("nginx")
                .hostConfig(hostConfig)
                .attachStderr(false).attachStdin(false).attachStdout(false)
                .build(), "mynginx");
        String id = container.id();

        // 컨테이너 시작
        dc.startContainer(id);
    }

    /**
     * https 사용하는 도커 서버 연결 후 docker info 출력,
     * keys 는 https 인증 파일이 위차한 폴더,
     * 프로젝트 기준으로 절대 경로 또는 상대 경로 입력
     */
    private static void httpsInfo() throws DockerCertificateException, DockerException, InterruptedException {
        DockerClient dc = DefaultDockerClient.builder()
                .uri(DOCKER_HTTPS_IP)
                .dockerCertificates(new DockerCertificates(Paths.get("keys")))
                .build();
        System.out.println(dc.info());
        dc.close();
    }

    /**
     * docker info 출력
     */
    private static void dockerInfo() throws DockerException, InterruptedException {
        DockerClient dc = new DefaultDockerClient(DOCKER_HTTP_IP);
        System.out.println(dc.info());
        dc.close();
    }
}