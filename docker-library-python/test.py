# 유닉스 소켓에 연결해 도커 엔진 정보 출력

import docker

client = docker.DockerClient(base_url='unix://var/run/docker.sock')
client.info()
