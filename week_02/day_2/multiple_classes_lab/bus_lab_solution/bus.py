class Bus:
    def __init__(self, route_number, destination):
        self.route_number = route_number
        self.destination = destination
        self.passengers = []

    def passenger_count(self):
        return len(self.passengers)

    def pick_up(self, passenger_to_pick_up):
        self.passengers.append(passenger_to_pick_up)

    def pick_up_from_stop(self, bus_stop_to_pick_up_from):
        for passenger in bus_stop_to_pick_up_from.queue:
            self.passengers.append(passenger)
        bus_stop_to_pick_up_from.clear()

    def drop_off(self, passenger_to_drop_off):
        self.passengers.remove(passenger_to_drop_off)

    def empty_bus(self):
        self.passengers.clear()

    def drive(self):
        return "Brum brum"
