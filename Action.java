public class Action {
  String[] validInput;
  IGoable action;

  public Action(String[] newValidInput, IGoable newAction) {
    validInput = newValidInput;
    action = newAction;
  }
  
}
