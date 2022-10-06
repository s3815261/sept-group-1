class AppointmentModel {
  int id;
  DateTime bookingStart;
  DateTime bookingEnd;

  AppointmentModel({
    required this.bookingEnd, required this.bookingStart, required this.id
  });

  static List<AppointmentModel> getAppointments() {
    List<AppointmentModel> appointments = <AppointmentModel>[];

    return appointments;
  }


}