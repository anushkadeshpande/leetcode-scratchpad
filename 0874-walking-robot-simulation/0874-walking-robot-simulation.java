class Solution {
    public Set<String> obstacleSet;
    public int robotSim(int[] commands, int[][] obstacles) {
        obstacleSet = new HashSet<>();
        
        for(int i=0; i<obstacles.length; i++)
            obstacleSet.add(obstacles[i][0] + ":" + obstacles[i][1]);
        
        int xPos = 0;
        int yPos = 0;
        int maxDistance = 0;
        
        char direction = 'N';
        
        for(int i=0; i<commands.length; i++) {
            if(commands[i] == -1) {
                // turn right
                // turnTo = "Right";
                if(direction == 'N') {
                    direction = 'E';
                } else if(direction == 'E') {
                    direction = 'S';
                } else if(direction == 'S') {
                    direction = 'W';
                } else
                    direction = 'N';
                // i++;
            } 
            else if(commands[i] == -2) {
                // turn right
                // turnTo = "Left";
                if(direction == 'N') {
                    direction = 'W';
                } else if(direction == 'W') {
                    direction = 'S';
                } else if(direction == 'S') {
                    direction = 'E';
                } else
                    direction = 'N';
                // i++;
            }
            else if(commands[i] >= 1 && commands[i] <= 9) {
                // check the direction
                if(direction == 'N')
                    yPos = updateDistance(xPos, yPos, 'N', commands[i]);
                else if(direction == 'S')
                    yPos = updateDistance(xPos, yPos, 'S', commands[i]);
                else if(direction == 'W')
                    xPos= updateDistance(xPos, yPos, 'W', commands[i]);
                else if(direction == 'E')
                    xPos = updateDistance(xPos, yPos, 'E', commands[i]);
               
                System.out.println(direction + ":" + xPos + ":" + yPos);
                
                maxDistance = Math.max(maxDistance, (xPos * xPos) + (yPos * yPos));
                
            }
        }
        
        return maxDistance;
    }
    
    public int updateDistance(int xPos, int yPos, char direction, int units) {
        for(int i=0; i<units; i++) {
            // if(obstacleSet.contains(xPos + ":" + yPos))
            //     break;
            if(direction == 'N') {
                if(obstacleSet.contains(xPos + ":" + (yPos+1))) 
                    break;
            }
            else if(direction == 'S') {
                // System.out.println("Checking for " + xPos + ":" + (yPos-1));
                if(obstacleSet.contains(xPos + ":" + (yPos-1))) 
                    break; 
            }
            else if(direction == 'W') {
                if(obstacleSet.contains((xPos-1) + ":" + yPos))
                    break;
            }
            else if(direction == 'E') {
                if(obstacleSet.contains((xPos+1) + ":" + yPos))
                    break;
            }
            
            if(direction == 'N')
                yPos++;
            else if(direction == 'S')
                yPos--;
            else if(direction == 'W')
                xPos--;
            else
                xPos++;
            
            
            
        }
        
        if(direction == 'N' || direction == 'S')
            return yPos;
        return xPos;
    }
}