class Point:

    def __init__(self, a: int = 0, b:int = 0):
        self.x = a
        self.y = b
    
    @property
    def x(self):
        return self._x

    @x.setter
    def x(self, a:int):
        self._x= int(a)
    
    @property
    def y(self):
        return self._y

    @y.setter
    def y(self,a:int):
        self._y = int(a)

class Direction:
    #constant directions dictionary
    DB = {'N':0, 'E':1, 'S':2, 'W':3}
    NONE = -1
    _direction = NONE

    @property
    def direction(self):
        return self._direction
    
    @direction.setter
    def direction(self, value:str or int):
        if isinstance(value,str):
            value = value.strip()
            # if gotten from input 'n' to 0
            if value in self.DB:
                self._direction = self.DB[value]
            else:
                raise ValueError('Invalid char Direction: ',value)
            
        elif isinstance(value,int) and 0 <= value <= 3:
            self._direction = value
        
        # default value for first instant
        elif isinstance(value,int) and value == self.NONE:
            return
        else:
            raise ValueError('Invalid Direction: ',value)

    def __init__(self):
        self.direction = self.NONE
        return
    
    def isPositive(self,number:int)->bool:
        if number > 0:
            return True
        return False
    
    def isNegative(self, number:int)->bool:
        if number < 0:
            return True
        return False
    
    #deciding the gradient and directions for making turns
    def get_turns(self, dx:int, dy:int)->list:
        to_turns = list()
        
        if self.isPositive(dx):
            to_turns.append(self.DB['E'])
        elif self.isNegative(dx):
            to_turns.append(self.DB['W'])
        
        if self.isPositive(dy):
            to_turns.append(self.DB['N'])
        elif self.isNegative(dy):
            to_turns.append(self.DB['S'])
        
        return to_turns
    
    #directionc changes to making int value
    def turns_taken(self, changes: list) -> int:
        start = self.direction
        countr = 0
        MAX_LEN = len(self.DB)
        
        for i in changes:
            countr += min( (i - start + MAX_LEN) % MAX_LEN, (start - i + MAX_LEN) % MAX_LEN )
            start = i
        return countr
    
    #calculating final answer of turns
    def calc_turns(self, dx:'int', dy:'int')-> int:
        turns = self.get_turns(dx,dy)

        #clockwise and counterclockwise movement and turns needed
        ans = min (self.turns_taken(turns) , self.turns_taken(list(reversed(turns))))
        
        return ans