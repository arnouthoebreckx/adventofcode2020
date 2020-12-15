input = []
with open('input.txt') as file:
  for number in file:
    input.append(int(number))

def sumOfInts(input, num_nums):
  indices = [0]*num_nums # creates 0 array of size num_nums
  indices[-1] = -1 # last value of indices is equal to -1 which will be used for last value of input
  for i in range(len(indices) - 1):
    indices[i] = i # set indices equal to i based on length (if num_nums == 2 then len == 2)

  input.sort()
  found = False

  while not found:
    s = sum([input[i] for i in indices])
    if s == 2020:
      found = True
      nums = [input[i] for i in indices] # for the values in indices take them from input
      prod = 1
      for num in nums:
        prod *= num
      return prod
    elif s > 2020:
      indices[-1] -= 1
      for i in range(len(indices)-1):
        indices[i] = i # reset the indices because last value changed
    else:
      for i in range(len(indices)-1):
        if indices[i]+1 != indices[i+1]: # if the value in indices + 1 != to the next value in indices array
          indices[i] += 1
          break

print(sumOfInts(input, 2))
print(sumOfInts(input, 3))