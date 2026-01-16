FROM ubuntu:14.04
RUN apt-get update
RUN apt-get install apache2 -y
ADD entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# 포트 개방 추가
EXPOSE 80

# ENTRYPOINT를 파일 단독으로 설정 (인자를 받을 수 있도록)
#ENTRYPOINT ["/bin/bash", "/entrypoint.sh"]
ENTRYPOINT ["/entrypoint.sh"]
