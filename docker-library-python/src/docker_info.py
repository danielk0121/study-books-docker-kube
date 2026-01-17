# 유닉스 소켓에 연결해 도커 엔진 정보 출력

import docker
import json

# **print(info)**를 추가하면 결과가 인텔리제이 하단의 [Run] 탭에 출력될 것입니다.
# client.info()는 값을 반환하지만 자동으로 화면에 출력되지는 않으므로,
# 코드를 실행할 때는 반드시 print() 문을 사용해야 합니다.

# 소켓 경로의 '가상화' 및 마운트
#
# 핵심은 도커 데스크탑이 macOS 호스트와 VM 게스트 간의 파일 시스템을 공유하고 있다는 점입니다.
#
# 호스트-게스트 파일 동기화: 도커 데스크탑은 특정 경로(예: /var/run/docker.sock)에 대한 접근 요청이 들어왔을 때,
#   이를 VM 내부의 실제 소켓 파일로 연결해 주는 바인드 마운트(Bind Mount) 또는 심볼릭 링크와 유사한 매커니즘을 사용합니다.
#
# 실제 경로는 다름: macOS의 /var/run/docker.sock은 실제로는 macOS 파일 시스템 어딘가에 있는 가상의 통신 지점이며,
#   이 지점에 데이터가 쓰이면 도커 데스크탑이 가로채서 VM으로 전달합니다.

print(1)
client = docker.DockerClient(base_url='unix://var/run/docker.sock')
print(2)
info = client.info()
print(json.dumps(info, indent=4, ensure_ascii=False, sort_keys=True))
