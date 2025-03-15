public class MySinglyLinkedList {

  MyNode top;
  int count;

  public MySinglyLinkedList() {
      top = null;
      count = 0;
  }

  // bool Search(Object o)
  public boolean Search(Object o) {
      if (!isEmpty()) {
          MyNode myCurrentTempTop = top;
          while (myCurrentTempTop != null) {
              if (myCurrentTempTop.item.toString().equalsIgnoreCase(o.toString())) {
                  return true;
              }
              myCurrentTempTop = myCurrentTempTop.next;
          }
      }
      return false;
  }

  // int SearchPart2(Object o)
  public int SearchTwo(Object o) {
      if (!isEmpty()) {
          MyNode myCurrentTempTop = top;
          int index = 0;
          while (myCurrentTempTop != null) {
              if (myCurrentTempTop.item.toString().equalsIgnoreCase(o.toString())) {
                  return index;
              }
              index = index + 1;
              myCurrentTempTop = myCurrentTempTop.next;
          }
      }
      return -1;
  }

  // bool Delete(Object o)
  public boolean Delete(Object o) {
      if (!isEmpty() && Search(o)) {
          // Scenario 1: If the list only contains One item and it is the one to be deleted
          if (top.item.toString().equalsIgnoreCase(o.toString()) && top.next == null) {
              top = null;
              return true;
          }
          // Scenario 2: If the List only contains 2 items and The item to be deleted is the top
          else if (top.item.toString().equalsIgnoreCase(o.toString()) && top.next != null) {
              top = top.next;
              return true;
          }
          // Scenario 3: If the item to be deleted is in between the list or at the last
          else {
              MyNode myCurrentTop = top;
              MyNode myPreviousTop = null;
              while (myCurrentTop != null && !myCurrentTop.item.toString().equalsIgnoreCase(o.toString())) {
                  myPreviousTop = myCurrentTop;
                  myCurrentTop = myCurrentTop.next;
              }
              if (myCurrentTop != null) {
                  myPreviousTop.next = myCurrentTop.next;
                  return true;
              }
          }
      }
      return false;
  }

  // bool DeleteByLocation(int location)
  public boolean DeleteByLocation(int location) {
      if (!isEmpty() && isLocationValid(location)) {
          // Scenario 1: If the list only contains One item and it is the one to be deleted
          if (location == 0) {
              top = top.next;
              return true;
          }
          // Scenario 2: If the item to be deleted is in between the list or at the last
          else {
              MyNode myCurrentTempTop = top;
              MyNode myPreviousTempTop = null;
              int index = 0;
              while (index < location) {
                  myPreviousTempTop = myCurrentTempTop;
                  myCurrentTempTop = myCurrentTempTop.next;
                  index = index + 1;
              }
              myPreviousTempTop.next = myCurrentTempTop.next;  // Corrected line
              return true;
          }
      }
      return false;
  }

  // bool Add(Object o)
  public boolean Add(Object o) {
      MyNode newNode = new MyNode();
      newNode.item = o;
      if (isEmpty()) {
          top = newNode;
      } else {
          MyNode myCurrentTempTop = top;
          while (myCurrentTempTop.next != null) {
              myCurrentTempTop = myCurrentTempTop.next;
          }
          myCurrentTempTop.next = newNode;
      }
      return true;
  }

  // Object Get(int location)
  public Object Get(int location) {
      if (!isEmpty() && isLocationValid(location)) {
          MyNode myCurrentTempTop = top;
          int index = 0;
          while (index < location) {
              myCurrentTempTop = myCurrentTempTop.next;
              index = index + 1;
          }
          if (myCurrentTempTop != null) {
              return myCurrentTempTop.item;
          }
      }
      return null;
  }

  // bool Edit(Object oldItem, Object newItem)
  public boolean Edit(Object oldItem, Object newItem) {
      if (!isEmpty() && Search(oldItem) && !Search(newItem)) {
          MyNode myCurrentTempTop = top;
          while (myCurrentTempTop != null) {
              if (myCurrentTempTop.item.toString().equalsIgnoreCase(oldItem.toString())) {
                  myCurrentTempTop.item = newItem;
                  return true;
              }
              myCurrentTempTop = myCurrentTempTop.next;
          }
      }
      return false;
  }

  // String toString()
  @Override
  public String toString() {
      String result = "";
      if (!isEmpty()) {
          MyNode myCurrentTempTop = top;
          while (myCurrentTempTop != null) {
              result += "[" + myCurrentTempTop.item.toString() + "] -> ";
              myCurrentTempTop = myCurrentTempTop.next;
          }
      }
      return result;
  }

  // Helpers
  // bool isFull()
  public boolean isFull() {
      return false;
  }

  // bool isLocationValid(int location)
  public boolean isLocationValid(int location) {
      return location >= 0 && location <= getCount() - 1;
  }

  // bool isEmpty()
  public boolean isEmpty() {
      return top == null;
  }

  // int getCount()
  public int getCount() {
      int count = 0;
      if (!isEmpty()) {
          MyNode tempTop = top;
          while (tempTop != null) {
              count = count + 1;
              tempTop = tempTop.next;
          }
      }
      return count;
  }
}