import 'package:flutter/material.dart';
import 'package:frontend/home.dart';

class Splash extends StatefulWidget {
  const Splash({Key? key}) : super(key: key);

  @override
  _SplashState createState() => _SplashState();
}

class _SplashState extends State<Splash> {
  @override
  void initState() {
    super.initState();
    _navigateToHome();
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    precacheImage(const AssetImage("assets/images/splash/splash_00.jpeg"), context);
  }

  _navigateToHome() async {
    await Future.delayed(const Duration(milliseconds: 2500), () {});
    Navigator.pushReplacement(
        context,
        MaterialPageRoute(
            builder: (context) => const Home(
                  title: "ND Telemedicine",
                )
        )
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Container(
      width: MediaQuery.of(context).size.width,
      height: MediaQuery.of(context).size.height,
      decoration: const BoxDecoration(
        image: DecorationImage(
            image: AssetImage("assets/images/splash/splash_00.jpeg"),
            fit: BoxFit.cover),
      ),
      padding: const EdgeInsets.only(top: 100.0),
      child: Center(
        child: Column(
          children: const <Widget>[
          Text('ND', style: TextStyle(fontSize: 100, fontWeight: FontWeight.bold),),
          Text('Telemedicine', style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold),),
        ],
      )
      ),
    )
    );
  }
}
