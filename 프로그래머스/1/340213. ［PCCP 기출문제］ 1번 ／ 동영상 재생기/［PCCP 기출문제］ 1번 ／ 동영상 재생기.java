class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int lenSecond = timeToSecond(video_len);
        int posSecond = timeToSecond(pos);
        int opStartSecond = timeToSecond(op_start);
        int opEndSecond = timeToSecond(op_end);

        for (String command : commands) {
            if (opStartSecond <= posSecond && posSecond <= opEndSecond) posSecond = opEndSecond;
            if (command.equals("next")) {
                posSecond += 10;
                if (posSecond > lenSecond) posSecond = lenSecond;
            } else if (command.equals("prev")) {
                posSecond -= 10;
                if (posSecond < 0) posSecond = 0;
            }
            if (opStartSecond <= posSecond && posSecond <= opEndSecond) posSecond = opEndSecond;
        }
        return secondToTime(posSecond);
    }

    public int timeToSecond(String time) {
        int mm = Integer.parseInt(time.substring(0, 2)) * 60;
        int ss = Integer.parseInt(time.substring(3));
        return mm + ss;
    }

    public String secondToTime(int second) {
        String mm = Integer.toString(second / 60);
        String ss = Integer.toString(second % 60);
        if (mm.length() == 1) mm = "0" + mm;
        if (ss.length() == 1) ss = "0" + ss;
        return mm + ":" + ss;
    }
}