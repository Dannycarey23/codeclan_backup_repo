import pdb 
from models.task import Task
import repositories.task_repository as task_repository  

result = task_repository.select_all()

for task in result:
    print(task.__dict__)

pdb.set_trace()