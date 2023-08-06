class Task:
    
    def __init__(self, description, assignee, duration, completed = False,  id = None, ):
        self.description = description
        self.assignee = assignee
        self.duration = duration
        self.completed = completed
        self.id = id
        
    def mark_complete(self):
        self.completed = True