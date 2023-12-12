def solution(k, tangerine):
    dic = {}
    for t in tangerine:
        if t in dic:
            dic[t] += 1
        else:
            dic[t] = 1
    dic = dict(sorted(dic.items(), key = lambda x: x[1], reverse=True))
    result = 0
    for i in dic:
        if k <= 0:
            return result
        k -= dic[i]
        result += 1
    return result