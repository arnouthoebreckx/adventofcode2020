with open("input.txt") as file:
  ids = set()
  for line in file.readlines():
    binary = []
    for val in line.rstrip():
      if val == "B" or val == "R":
        binary.append('1')
      else: 
        binary.append('0')
    ids.add(int(''.join([val for val in binary]),2))

print(max(ids))
print(set(range(min(ids),max(ids))) - ids) # mega big brain van Xavier gepakt, set heeft enkel unieke values dus als je eentje genereert van min naar max en de andere eraf trekt krijg je de missing