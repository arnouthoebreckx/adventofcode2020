import re

required = ["byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"]
passports = []

def passportParse(lines):
    passDict = dict()
    for line in lines:
        line = line.strip()
        if len(line) > 0:
            splitlines = line.split(' ')
            for splLine in splitlines:
                k,v = splLine.split(':')
                passDict[k] = v
        else:
            passports.append(passDict)
            passDict = dict()
    
    ## last one
    passports.append(passDict)

def is_valid_passport(passport):
    for req in required:
        if req not in passport:
            return False
    return True

def is_valid_hgt(hgt):
    if "cm" in hgt:
        return 150 <= int(hgt[0:-2]) <= 193
    elif "in" in hgt:
        return 59 <= int(hgt[0:-2]) <= 76
    else: 
        return False

def is_valid_input(passport):
    ecl = ["amb", "blu", "brn", "gry", "grn", "hzl", "oth"]
    return (1920 <= int(passport["byr"]) <= 2002)\
        and (2010 <= int(passport["iyr"]) <= 2020)\
        and (2020 <= int(passport["eyr"]) <= 2030)\
        and (is_valid_hgt(passport["hgt"]))\
        and (re.match(r"^#[a-f0-9]{6}", passport["hcl"]))\
        and (passport["ecl"] in ecl)\
        and (re.match(r"^[0-9]{9}", passport["pid"]))


file = open('input.txt')
lines = file.readlines()
passportParse(lines)
first = sum([1 for p in passports if is_valid_passport(p)])
scn = sum([1 for p in passports if is_valid_passport(p) and is_valid_input(p) ])

print(first)
print(scn)




# print(lines)
