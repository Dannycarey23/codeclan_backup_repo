class BusStop:
    def __init__(self, name):
        self.name = name
        self.queue = []

    def queue_length(self):
        return len(self.queue)

    def add_to_queue(self, person_to_add):
        self.queue.append(person_to_add)

    def clear(self):
        self.queue.clear()
