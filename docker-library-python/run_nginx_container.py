# nginx 생성 예제

import docker

client = docker.DockerClient(base_url='unix://var/run/docker.sock')
container = client.containers.run('nginx', detach=True, ports={'80/tcp':80})
print("Created Container is : {}, {}"
  .format(container.name, container.id))
