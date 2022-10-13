import 'package:flutter/material.dart';
import 'package:frontend/common/theme_constants.dart';

class ThemeLite{

  InputDecoration textInputDecoration([String labelText="", String hintText = ""]){
    return InputDecoration(
      labelText: labelText,
      hintText: hintText,
      fillColor: Colors.white,
      filled: true,
      contentPadding: const EdgeInsets.fromLTRB(10, 5, 10, 10),
      focusedBorder: UnderlineInputBorder(borderRadius: BorderRadius.circular(0), borderSide: BorderSide(color: ThemeConstants().accentColor, width: 1.5)),
      enabledBorder: UnderlineInputBorder(borderRadius: BorderRadius.circular(0), borderSide: BorderSide(color: ThemeConstants().secondaryColor, width: 2)),
      errorBorder: OutlineInputBorder(borderRadius: BorderRadius.circular(0), borderSide: BorderSide(color: ThemeConstants().errorColor, width: 1.0)),
      focusedErrorBorder: UnderlineInputBorder(borderRadius: BorderRadius.circular(0), borderSide: BorderSide(color: ThemeConstants().errorColor, width: 2.0)),
    );
  }

  BoxDecoration inputBoxDecorationShadow() {
    return const BoxDecoration(boxShadow: [
      // BoxShadow(
      //   color: Colors.black.withOpacity(0.1),
      //   blurRadius: 20,
      //   offset: const Offset(0, 5),
      // )
    ]);
  }

  LinearGradient linearGradient() {
    return const LinearGradient(
      begin: Alignment.bottomLeft,
      end: Alignment.topRight,
      colors: [
        Color(0xFF5273ED),
        Color(0xFF8517DF),
      ],
    );
  }

}