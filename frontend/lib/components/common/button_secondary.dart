import 'package:flutter/material.dart';

class ButtonSecondary extends StatelessWidget {
  final String text;
  final double width;
  final double height;
  final double fontSize;
  final Function callback;
  const ButtonSecondary(
      {
        super.key,
        required this.text,
        this.width = 0,
        this.height = 0,
        this.fontSize = 14,
        required this.callback
      }
      );

  @override
  build(BuildContext context) {
    return InkWell(
        onTap: () => callback(),
        child: Container(
          width: width == 0 ? null : width,
          height: height == 0 ? null : height,
          margin: const EdgeInsets.all(20),
          padding: const EdgeInsets.fromLTRB(25, 10, 25, 10),
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(10),
            border: Border.all(
              color: const Color(0xFFFFFFFF),
              width: 1.5,
            ),
          ),
          child: Text(
            text,
            style:  TextStyle(
              fontWeight: FontWeight.w400,
              fontSize: fontSize,
              color: const Color(0xFFFFFFFF),
            ),
          ),
        )
    );
  }
}