# nginx 생성 예제

import docker

client = docker.DockerClient(base_url='unix://var/run/docker.sock')
container_name = 'nginx_python'

# docker run
container = client.containers.run('nginx', detach=True, ports={'80/tcp': 80}, name=container_name)
print("Created Container is : {}, {}"
      .format(container.name, container.id))

# docker rm -f
# container = client.containers.get(container_name)
# container.remove(force=True)
