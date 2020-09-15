class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        incrementMinutes();
    }

    void incrementHours(){
        hours++;
        if(hours > 12){
            hours = 1;
        }
    }

    void incrementMinutes(){
        minutes++;
        if(minutes >59){
            incrementHours();
            minutes = 0;
        }
    }
}