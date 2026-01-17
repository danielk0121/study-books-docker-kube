# HTTPS 도커 서버에 연결 예제

import docker

tls_config = docker.tls.TLSConfig(
    client_cert=('/root/.docker/cert.pem', '/root/.docker/key.pem')
)
client = docker.DockerClient(base_url='unix://var/run/docker.sock', tls=tls_config)
print(client.info())
