
def binary_search(arr:list, low:int, high:int, x:int) -> list[int]:
 
    if high >= low:
 
        mid = (high + low) // 2
 
       
        if arr[mid] == x:
            return mid
 
        elif arr[mid] > x:
            return binary_search(arr, low, mid - 1, x)

        else:
            return binary_search(arr, mid + 1, high, x)
 
    else:
        return -1
n = int(input("Enter the max number of element: "))
for _ in range(n):
  arr.append(input(f"enter {_} element: "))
arr = []
x = int(input("Enter value to search: "))
 
result = binary_search(arr, 0, len(arr)-1, x)
 
if result != -1:
    print("Element is present at index", str(result))
else:
    print("Element is not present in array")
