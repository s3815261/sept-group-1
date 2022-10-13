import 'package:frontend/components/chat/chat_bubble.dart';
import 'package:frontend/components/chat/chat_detail.dart';
import 'package:frontend/components/chat/chat_message_model.dart';
import 'package:frontend/components/chat/send_menu_items.dart';
import 'package:flutter/material.dart';
import 'package:frontend/common/animation.dart';

import '../components/common/icon_button.dart';
import 'package:frontend/common/flow_theme.dart';

enum MessageType {
  Sender,
  Receiver,
}

final animationsMap = {
  'circleImageOnPageLoadAnimation': AnimationInfo(
    curve: Curves.bounceOut,
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 19),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
  'textOnPageLoadAnimation1': AnimationInfo(
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    delay: 50,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 20),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
  'textFieldOnPageLoadAnimation1': AnimationInfo(
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    delay: 100,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 20),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
  'textFieldOnPageLoadAnimation2': AnimationInfo(
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    delay: 200,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 40),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
  'textFieldOnPageLoadAnimation3': AnimationInfo(
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    delay: 200,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 60),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
  'textOnPageLoadAnimation2': AnimationInfo(
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    delay: 250,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 50),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
  'radioButtonOnPageLoadAnimation': AnimationInfo(
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    delay: 300,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 50),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
  'buttonOnPageLoadAnimation1': AnimationInfo(
    curve: Curves.bounceOut,
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    delay: 350,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 40),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
  'buttonOnPageLoadAnimation2': AnimationInfo(
    curve: Curves.bounceOut,
    trigger: AnimationTrigger.onPageLoad,
    duration: 600,
    delay: 400,
    hideBeforeAnimating: false,
    fadeIn: true,
    initialState: AnimationState(
      offset: const Offset(0, 40),
      opacity: 0,
    ),
    finalState: AnimationState(
      offset: const Offset(0, 0),
      opacity: 1,
    ),
  ),
};


class ChatWidget extends StatefulWidget {
  const ChatWidget({Key? key}) : super(key: key);

  @override
  _ChatWidgetState createState() => _ChatWidgetState();
}

class _ChatWidgetState extends State<ChatWidget> {
  final scaffoldKey = GlobalKey<ScaffoldState>();
  TextEditingController? messageController;


  List<ChatMessage> chatMessage = [
    ChatMessage(
        message: "Hi John",
        type: MessageType.Receiver),
    ChatMessage(
        message: "Hope you are doing good.",
        type: MessageType.Receiver),
    ChatMessage(
        message: "Hello Randy, I'm doing good. Thank you for asking.",
        type: MessageType.Sender),
    ChatMessage(
        message: "This is just a message to show the auto wrapping feature. When messages are longer they wrap to the next line.",
        type: MessageType.Receiver),
    ChatMessage(
        message: "Oh! Nice. It's looking good.",
        type: MessageType.Sender),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: scaffoldKey,
      appBar: AppBar(
        backgroundColor: FlowTheme.of(context).alternate,
        automaticallyImplyLeading: false,
        leading: InkWell(
          onTap: () async {
            Navigator.pop(context);
          },
          child: ButtonIcon(
            borderColor: Colors.transparent,
            borderRadius: 30,
            borderWidth: 1,
            buttonSize: 60,
            icon: const Icon(
              Icons.arrow_back_ios,
              color: Color(0xFF1D2429),
              size: 30,
            ),
            onPressed: () async {
              Navigator.pop(context);
            },
          ),
        ),
        title: Align(
          alignment: const AlignmentDirectional(-1, 0),
          child: Text(
            'Randy Rudolph',
            style: FlowTheme.of(context).subtitle2.override(
              fontFamily: 'Outfit',
              color: FlowTheme.of(context).primaryText,
            ),
          ),
        ),
        actions: [],
        centerTitle: false,
        elevation: 2,
      ),
      backgroundColor: FlowTheme.of(context).primaryBackground,
      body: SafeArea(
        child: GestureDetector(
          onTap: () => FocusScope.of(context).unfocus(),
          child: Stack(
            // mainAxisSize: MainAxisSize.max,
            // mainAxisAlignment: MainAxisAlignment.start,
            // crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              ListView.builder(
                itemCount: chatMessage.length,
                shrinkWrap: true,
                padding: const EdgeInsets.only(top: 10, bottom: 10),
                physics: const BouncingScrollPhysics(),
                itemBuilder: (context, index) {
                  return ChatBubble(
                    chatMessage: chatMessage[index],
                  );
                },
              ),
              Align(
                alignment: Alignment.bottomLeft,
                child: Container(
                  padding: const EdgeInsets.only(left: 10, bottom: 10),
                  height: 80,
                  width: double.infinity,
                  // color: Colors.white,
                  child: Container(
                    margin: const EdgeInsets.all(15.0),
                    height: 61,
                    child: Row(
                      children: [
                        Expanded(
                          child: Container(
                            decoration: BoxDecoration(
                              color: Colors.white,
                              borderRadius: BorderRadius.circular(35.0),
                              boxShadow: const [
                                BoxShadow(
                                    offset: Offset(0, 3),
                                    blurRadius: 5,
                                    color: Colors.grey)
                              ],
                            ),
                            child: Row(
                              children: [
                                // IconButton(
                                //     icon: Icon(
                                //       Icons.face,
                                //       color: Colors.blueAccent,
                                //     ),
                                //     onPressed: () {}),
                                IconButton(
                                  icon: Icon(Icons.attach_file,
                                      color: FlowTheme.of(context).primaryText),
                                  onPressed: () {},
                                ),
                                Expanded(
                                  child: TextField(
                                    decoration: InputDecoration(
                                      hintText: "Type Something...",
                                      hintStyle:
                                      TextStyle(color: FlowTheme.of(context).primaryText),
                                      border: InputBorder.none,
                                      contentPadding: const EdgeInsetsDirectional.fromSTEB(0, 0, 0, 10),
                                    ),
                                  ),
                                ),
                                IconButton(
                                  icon: Icon(Icons.send_rounded,
                                      color: FlowTheme.of(context).primaryText,
                                  ),
                                  onPressed: () {},
                                ),
                              ],
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
