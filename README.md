# java-racingcar-precourse
기능 목록 (체크리스트)

A. 입력
 자동차 이름 입력: Console.readLine()으로 한 줄 입력 받기
- [ ] 쉼표 , 기준 분리
- [ ] 각 이름 공백 트림
- [ ] 빈 토큰 금지 (예: pobi,,jun → 예외)
- [ ] 이름 길이 1~5자(초과 시 예외)

 시도 횟수 입력: Console.readLine()으로 한 줄 입력 받기
- [ ] 정수 변환(문자/음수/0 → 예외)



B. 도메인 로직
 Car: 이름/위치 보유, moveIf(MoveStrategy) 구현

 MoveStrategy: 전진 가능 여부 인터페이스

 RandomMoveStrategy: Randoms.pickNumberInRange(0, 9) ≥ 4 → 전진

 Cars:
- [ ] 이름 리스트로 Car 목록 생성
- [ ] 라운드 이동: 차량마다 1회 전략 판단 호출
- [ ] 스냅샷 생성(출력용 이름→거리 맵)
- [ ] 우승자 계산(최대 거리 동점 허용)



C. 출력
 제목 출력: 실행 결과 (앞에 빈 줄 금지)

 라운드별 결과: 이름 : ---- (콜론 앞뒤 공백 정확)

 빈 줄 1줄: 라운드 사이 가독성(필요 시)

 최종 우승자: 최종 우승자 : pobi, jun



D. 예외/종료 정책
 잘못된 입력 시 즉시 IllegalArgumentException 던지고 종료

 System.exit() 금지



E. 테스트 (도메인 위주)
 Car: 전략 참/거짓에 따른 이동/정지

 NameParser: 정상 파싱 / 빈 토큰 예외 / 길이 예외

 Cars: 우승자 계산(동점 포함)

 통합: ApplicationTest가 통과 (assertRandomNumberInRangeTest, assertSimpleTest)