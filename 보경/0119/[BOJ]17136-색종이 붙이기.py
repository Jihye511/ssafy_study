#1 전체 위치 저장
#크기 탐색 -> 좌,하,대각선
#붙였다 뗐다 하면서 최솟값을 구해야함 dfs
#색종이를 다쓰거나
# min_count보다 커지면 탐색 종료 후 다른 길 찾기 백트랙킹 !!! <- 중요 0.4초 줄임
#단순히 1부터 5까지 다 붙여보면됨
import sys
sys.setrecursionlimit(10**7)

board = []
min_count = 26
for _ in range(10):
    board.append(list(map(int, input().split())))
papers = [0,0,0,0,0] #사이즈별로 사용한 색종이 수 5개를 넘길 수 없다

def check(size,curr_r,curr_c):
    #len 크기의 색종이를 붙일 수 있는지 확인 0에만 붙여야되고 이미 붙인 영역에 겹쳐지면 안된다
    for i in range(curr_r,curr_r+size+1):
        for j in range(curr_c,curr_c+size+1):
            if not board[i][j]:
                return False
    return True

def put_papers(r,c,size): #사이즈 4 3 2 1 0
    papers[size] += 1
    for i in range(r, r + size + 1):
        for j in range(c,c + size + 1):
            board[i][j] = 0

def remove_papers(r,c,size):
    papers[size] -= 1
    for i in range(r,r+size+1):
        for j in range(c,c+size+1):
            board[i][j] = 1

#한칸씩 탐색하면서 채울 수 있는 것 채우기
#한 줄 다 돌면 다음 줄

def stick(r,c,cnt):
    #0,0부터 한줄씩 탐색
    global min_count
    if cnt >= min_count:
        min_count = min_count
        return

    if c>=10:
        stick(r+1,0,cnt)
        return
    if r>=10:
        #끝
        min_count = min(min_count,cnt)
        return
    #탐색 시작
    if board[r][c] == 1:
        #색종이 크기별로 붙여보기
        for size in range(5): #4,3,2,1,0
            if papers[size] == 5:
                continue #해당 크기의 색종이 다 씀
            if r + size >= 10 or c + size >= 10:
                continue
            #붙일 수 있는지 확인
            if check(size,r,c):
                put_papers(r,c,size)

                #이후에 계속 붙이기
                stick(r,c+size+1,cnt+1)
                #백트래킹 시점
                #종이 떼야됨
                remove_papers(r,c,size)
    else:
        #다음칸 탐색
        stick(r,c+1,cnt)
stick(0,0,0)

if min_count >= 26:
    print(-1)
else:
    print(min_count)

#
