def insertionSort(arr1):
  
    for n in range(1, len(arr1)):
  
        ky = arr1[n]
  
        k = n-1
        while k >=0 and ky < arr1[k] :
                arr1[k+1] = arr1[k]
                k -= 1
        arr1[k+1] = ky
  
  

arr1 = [10,30,200,45,1,44,770]
insertionSort(arr1)
print ("Sorted array is:")
for n in range(len(arr1)):
    print ("%d" %arr1[n])