import pdb 
from models.task import Task
import repositories.task_repository as task_repository  

task_repository.delete_all()

task_1 = Task("Walk Dog", "Jack Jarvis", 60)

task_2 = Task("Feed Cat", "Victor McDade", 5)

print(task_1.__dict__)

task_repository.save(task_1)

res = task_repository.select_all()

for task in res:
    print(task.__dict__)

pdb.set_trace()