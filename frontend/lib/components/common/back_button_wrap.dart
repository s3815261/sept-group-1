import 'package:flutter/material.dart';
import 'package:frontend/common/theme_constants.dart';

class BackButtonWrap extends StatelessWidget {
  const BackButtonWrap({
    super.key,
  });

  @override
  build(BuildContext context) {
    double positioning = MediaQuery.of(context).size.width > 576
        ? MediaQuery.of(context).size.width > 768
        ? MediaQuery.of(context).size.width > 992
        ? 7.5
        : 5
        : 2.5
        : 0;

    double margin = MediaQuery.of(context).size.width > 576
        ? MediaQuery.of(context).size.width > 768
        ? MediaQuery.of(context).size.width > 992
        ? 17.5
        : 15
        : 12.5
        : 10;

    double padding = MediaQuery.of(context).size.width > 576
        ? MediaQuery.of(context).size.width > 768
        ? MediaQuery.of(context).size.width > 992
        ? 5
        : 3
        : 1.5
        : 0;


    return Positioned(
      top: positioning,
      left: positioning,
      child: Container(
        padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
        child: Container(
            margin: EdgeInsets.all(margin),
            padding: EdgeInsets.all(padding),
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              color: ThemeConstants().secondaryColor,
              // border: Border.all(width: imgSize * 0.04, color: Colors.white)
            ),
            child: const BackButton(
              color: Colors.white,
            )),
      ),
    );
  }
}