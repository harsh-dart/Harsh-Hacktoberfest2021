def shortest_path(graph, start, stop, path, dis, min):
    if start == stop and (min == None or (dis <= min[1] and len(path) <= len(min[0]))):
        min = [path, dis]
        return min

    for a in graph.get(start, []):
        if a[0] not in path:
            tmp = shortest_path(graph, a[0], stop, path + [a[0]], dis + a[1], min)
            if tmp is not None:
                min = tmp

    return min


if __name__ == '__main__':

    inp, case = input('Enter : ').split('/')

    graph = {}
    for a in inp.split(','):
        a = a.split()
        graph[a[0]] = graph.get(a[0], []) + [[a[2], int(a[1])]]

    for b in case.split(','):
        b = b.split()
        path = shortest_path(graph, b[0], b[1], [b[0]], 0, None)
        if path is None:
            print(f'Not have path : {b[0]} to {b[1]}')
            continue
        print(f'{b[0]} to {b[1]} : ' + '->'.join(path[0]))