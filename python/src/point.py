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
    DB = {'N':0, 'E':1, 'S':2, 'W':3}

    def __init__(self):
        self._direction = -1
        return
    
    @property
    def direction(self):
        return self._direction
    @direction.setter
    def direction(self, value:str or int):
        if isinstance(value,str):
            value = value.strip()
        if value in self.DB:
            self._direction = self.DB[value]
        elif isinstance(value,int) and 0 <= value <= 3:
            self._direction = value
        else:
            raise ValueError('Invalid Direction: ',value)
    
    def get_turns(self,dx:int, dy:int)->list:
        to_turns = []
        if dx > 0:
            to_turns.append(1)
        elif dx < 0:
            to_turns.append(3)
        if dy > 0:
            to_turns.append(0)
        elif dy < 0:
            to_turns.append(2)
        return to_turns
    
    def turns_taken(self, changes: list) -> int:
        start = self._direction
        countr = 0
        MAX_LEN = len(self.DB)
        
        for i in changes:
            countr += min( (i - start + MAX_LEN) % MAX_LEN, (start - i + MAX_LEN) % MAX_LEN )
            start = i
        
        return countr
    
    def calc_turns(self, dx:'int', dy:'int')-> int:
        turns = self.get_turns(dx,dy)
        
        ans = min(self.turns_taken(turns) , self.turns_taken(list(reversed(turns))))
        return ans