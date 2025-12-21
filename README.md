# 책, 시작하세요 도커/쿠버네티스, 실습과 요약

## 책 내용
- [02_02_docker_container.file](02_02_docker_container.file)
- [02_03_docker_image.file](02_03_docker_image.file)

## 추가 작업 파일
- [zsh_docker_cli_completion.file](zsh_docker_cli_completion.file)
- [m2_cpu_utm_ubuntu_docker.file](m2_cpu_utm_ubuntu_docker.file)
- [change_docker_cmd_alias.file](change_docker_cmd_alias.file)

## 목적
- 책완독
- 도커 사용 이해
- 컨테이너 사용의 한계점 파악
- 알파인, 비지박스, 데비안 등 이해
- 노트북 로컬 환경으로 쿠버 테스트 구축

## 참고
- 조금 오래된 책
  - 2020년 초판 발행, 작업은 2025년 12월 시작
  - 책은 amd64, 우분투 14 기준으로 작성됨
- cpu 아키텍처 문제
  - 책 예제는 amd64 사용
  - 작업 노트북은 맥북 m2 arm64 아키텍처 사용
  - cpu 아키텍처, 버전 등의 이슈가 생각보다 곳곳에서 발생한다
- 호스트 PC의 OS 문제
  - 책 앞 부분에 윈도우, 맥, 리눅스 환경에 따라 도커 설치 방법을 소개 해놨지만, 
  - 책 예제는 host 환경이 우분투 인 것으로 추정됨
  - 노트북은 맥을 최대한 사용 해볼 예정
- VM 이 필요함
  - m2 맥북에서 vm 올리는 내용은 [m2_cpu_utm_ubuntu_docker.file](m2_cpu_utm_ubuntu_docker.file) 참고
  - 최대한 m2 arm64 UTM vm 기준으로 진행하되, 필요하다면 윈도우 amd64 pc 를 사용할 예정
  - 애플 UTM 사용중인데, 버그 진짜 많다
  - UTM 에 스냅샷 기능이 없는건지, vm 복제만 있음, 맥북 디스크 용량 걱정됨
- AWS 계정 필요
  - 책 예제에서 aws 사용이 종종 된다
  - 일단 최대한 피하는 중
  - 아마 도커 사설 레포 사용 부터는 aws 필요할 듯

## 주요 이슈
- 책 예제에서 사용하는 mysql 5.7 이미지가 amd64 이미지
  - => 경고만 뜨고, arm64 에서 실행되서, 일단 그냥 사용
- ubuntu 14 LTS arm64 ISO 이미지 구하기 어려움
  - => ubuntu 24 arm64 ISO 사용
- m2 에서 virtualBox 사용 어려움
  - => 애플 UTM 가상화 소프트웨어 사용
- 책 예제에서 제공하는 커스텀 fluent 이미지가 amd64 이미지
  - => arm64 이미지로 따로 빌드해서 사용
