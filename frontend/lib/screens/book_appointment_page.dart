import 'package:flutter/material.dart';
class BookingAppointment extends StatefulWidget{
  const BookingAppointment({Key? key}) : super(key: key);
  
  @override
  State<StatefulWidget> createState() {
    return _BookApointmentPageState();
  }
}


class _BookApointmentPageState extends State<BookingAppointment>{
  DateTime dateTime = DateTime(2022, 9, 17);
  @override
  Widget build(BuildContext context) {
    final hours = dateTime.hour.toString().padLeft(2, '0');
    final mins = dateTime.minute.toString().padLeft(2, '0');
    return
      Scaffold(
        appBar: AppBar(title: const Text("Book Appointment",
                        style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
        ),
          backgroundColor: Colors.purpleAccent,
        ),
      backgroundColor: Colors.white,
      body: Container(
          height: 400,
          alignment: Alignment.center,
        child: Column(
          //mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const SizedBox(height: 20),
            const Text("Select A Time",
            style: TextStyle(fontSize: 32),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              child: Text('${dateTime.year}/${dateTime.month}/${dateTime.day}'),
              onPressed: () async {
                final date = await pickDate();
                if (date == null) return; //pressed 'Cancel!' Do not parse data to server

                final newDateTime = DateTime(
                  dateTime.year,
                  dateTime.month,
                  dateTime.day,
                  dateTime.hour,
                  dateTime.minute,
                );
                setState(() => dateTime = newDateTime); //Submit date
              },
            ),
            const SizedBox(height: 10),
            ElevatedButton(
              child: Text('$hours:$mins'),
              onPressed: () async {
                final time = await pickTime();
                if (time == null) return; //pressed 'Cancel!' Do not parse data to server

                final newDateTime = DateTime(
                  dateTime.year,
                  dateTime.month,
                  dateTime.day,
                  time.hour,
                  time.minute,
                );
                setState(() => dateTime = newDateTime);
              },
            ),
            const SizedBox(height: 10),
            const ElevatedButton(
              child: Text("Book Appointment"),
              onPressed: null,
              ),
          ],
        )
      ),
    );
  }
  
  Future<DateTime?> pickDate() => showDatePicker(
      context: context,
      initialDate: dateTime,
      firstDate: DateTime(2022),
      lastDate: DateTime(2030),
  );

  Future<TimeOfDay?> pickTime() => showTimePicker(
      context: context,
      initialTime: TimeOfDay(hour: dateTime.hour, minute: dateTime.minute)
  );
}