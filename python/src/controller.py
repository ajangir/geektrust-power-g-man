from src.solution import Solution,Point,Direction

# main controller
def runController(in_text:list):
    solver = Solution()

    for i in in_text:
        # strip \n and split via ' '
        tokens = i.strip().split()

        if tokens[0] == 'SOURCE':
            solver.makeStartPoint(tokens[1],tokens[2])
            solver.makeStartDirection(tokens[3])
        
        elif tokens[0] == 'DESTINATION':
            solver.makeEndPoint(tokens[1],tokens[2])
        
        elif tokens[0] == 'PRINT_POWER':
            solver.calculate_power()
        
        else:
            raise ValueError('Invalid token0:',i)
        
    return
