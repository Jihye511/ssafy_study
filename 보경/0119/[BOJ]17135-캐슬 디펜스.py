from itertools import combinations
from collections import deque
import copy
#이번턴에 죽인 적과, 이때까지 죽인 적 구분해야함
N, M, D = map(int, input().split())

game_map = []
for _ in range(N):
    game_map.append(list(map(int, input().split())))

max_count = 0

def kill(location):
    #location : 궁수가 배치되는 위치(열 숫자) ex) 0,1,2
    copyed = copy.deepcopy(game_map)
    killed = [[False] * M for _ in range(N)] #죽으면 True
    kill_count = 0
    for i in range(N-1,-1,-1):
        this_turn_killed = set()
        for l in location:
            directions = [(0, -1), (-1, 0), (0, 1)]  # 좌상우
            dq = deque([(i, l, 1)])
            while dq:
                curr_r, curr_c, level = dq.popleft()
                if copyed[curr_r][curr_c] == 1:
                    this_turn_killed.add((curr_r, curr_c))
                    if not killed[curr_r][curr_c]:
                        killed[curr_r][curr_c] = True
                        kill_count += 1
                    break
                if level < D:
                    for d in directions:
                        next_r = curr_r + d[0]
                        next_c = curr_c + d[1]
                        if 0 <= next_r < N and 0 <= next_c < M:
                            dq.append((next_r, next_c, level + 1))
        for res in this_turn_killed:
            copyed[res[0]][res[1]] = 0

    return kill_count

for group in combinations([i for i in range(M)], 3):
    # 궁수 위치 완전탐색
    max_count = max(max_count, kill(group))

print(max_count)