required = ["byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"]
passports = []

def passportParse(lines):
    passDict = dict()
    for line in lines:
        if len(line[0:-2]) > 0:
            splitlines = line[0:-2].split(' ')
            for splLine in splitlines:
                k,v = splLine.split(':')
                passDict[k] = v
        else:
            passports.append(passDict)
            passDict = dict()
    passports.append(passDict)

def is_valid(passport):
    count = 0
    for req in required:
        if req not in passport:
            count += 1
    return count == 0



file = open('input.txt')
lines = file.readlines()
passportParse(lines)
first = sum([1 for p in passports if is_valid(p)])

print(first)




# print(lines)
