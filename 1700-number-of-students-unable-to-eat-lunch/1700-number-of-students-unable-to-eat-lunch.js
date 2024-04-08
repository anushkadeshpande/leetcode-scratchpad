/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */

Array.prototype.pop = function() {
    this.splice(0, 1)
}

var countStudents = function(students, sandwiches) {
  let unableToEat = 0

  while(sandwiches.length !==0 && unableToEat < students.length) {
            
      // student gets the sandwich they want
      // and now we reset num of students unable to eat
      if(students[0] === sandwiches[0]) {
          students.pop()
          sandwiches.pop()
          unableToEat = 0
      }
      
      // student does not get the sandwich they want
      // move student at the end
      // increment unable to eat
      else {
          students.push(students[0])
          students.pop()
          
          unableToEat++
      }
  }
  
  return unableToEat
};