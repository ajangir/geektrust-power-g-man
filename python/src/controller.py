from src.solution import Solution,Point

def runController(in_text:'list'):
    solver = Solution()

    #print(in_text)
    for i in in_text:
        tokens = i.strip().split()

        if len(tokens) not in [1,3,4]:
            raise ValueError('Source line invalid:',i)
        
        if tokens[0] == 'SOURCE':
            solver.start = Point(tokens[1],tokens[2])
            solver.d.direction = tokens[3]
        
        elif tokens[0] == 'DESTINATION':
            solver.end = Point(tokens[1], tokens[2])
        
        elif tokens[0] == 'PRINT_POWER':
            solver.calculate_power()
        
        else:
            raise ValueError('Invalid token0:',i)
    return
