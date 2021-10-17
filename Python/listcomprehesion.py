if __name__ == '__main__':
    x = int(raw_input())
    y = int(raw_input())
    z = int(raw_input())
    n = int(raw_input())
    l = [[i,j,k] for i in range(1+x) for j in range(1+y) for k in range(1+z) if i+j+k!=n]
    print(l)
