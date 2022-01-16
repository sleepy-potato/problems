class Solution {
  // Unsorted, remove any adjacent duplicates, no repeat
  public int removeDuplicates(int[] arr) {
      int slow = 0;
      int fast1 = 0;
      while (fast1 < arr.length) {
          int fast2 = fast1 + 1;
          while (fast2 < arr.length && arr[fast2] == arr[fast1]) {
              fast2++;
          }
          if (fast2 == fast1 + 1) {
              arr[slow++] = arr[fast1];
          }
          fast1 = fast2;
      }
      return slow;
  }

  // Unsorted, remove adjacent duplicates (keep max k), no repeat
  public static int removeDuplicatesKeepK(int[] arr, int k) {
      int slow = 0;
      int fast1 = 0;
      while (fast1 < arr.length) {
          int fast2 = fast1 + 1;
          while (fast2 < arr.length && arr[fast2] == arr[fast1]) {
              fast2++;
          }
          if (fast2 <= fast1 + k) {
              while (fast1 < fast2) {
                  arr[slow++] = arr[fast1++];
              }
          }
          fast1 = fast2;
      }
      return slow;
  }

  // Unsorted, remove any adjacent duplicates, repeat
  public int removeDuplicatesRepeat(int[] arr) {
      int slow = 0;
      int fast1 = 0;
      int countDups = 0;
      while (fast1 < arr.length) {
          int fast2 = fast1 + 1;
          while (fast2 < arr.length && arr[fast2] == arr[fast1]) {
              fast2++;
              countDups++;
          }
          if (countDups == 0) {
              arr[slow++] = arr[fast1];
          } else {
              countDups = 0;
              if (slow > 0 && fast2 < arr.length && arr[slow - 1] == arr[fast2]) {
                  slow--;
                  countDups = 1;
              }
          }
          fast1 = fast2;
      }
      return slow;
  }
}
