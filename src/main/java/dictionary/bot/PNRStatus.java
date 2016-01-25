package dictionary.bot;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by harshit on 25/1/16.
 */
public class PNRStatus {
    private boolean error;
    private String train_name;
    private String train_num;
    private String pnr;
    private String doj;
    private List<Passengers> passengers;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getTrain_num() {
        return train_num;
    }

    public void setTrain_num(String train_num) {
        this.train_num = train_num;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "PNRStatus{" +
                "error=" + error +
                ", train_name='" + train_name + '\'' +
                ", train_num='" + train_num + '\'' +
                ", pnr='" + pnr + '\'' +
                ", doj='" + doj + '\'' +
                ", passengers=" + passengers +
                '}';
    }

    public String toJsonString() {
        return "train_name:" + train_name + ' ' +
                " train_num:" + train_num + ' ' +
                " pnr:" + pnr + ' ' +
                " date of journer:" + doj + ' ' +
                " passengers:" + toJsonStringPassengers();
    }

    private String toJsonStringPassengers() {
        return passengers.stream().map(w  -> w.toJsonString()).collect(Collectors.joining("\n"));
    }

    private class Passengers {
        private int no;
        private String booking_status;
        private String current_status;
        private int coach_position;

        @Override
        public String toString() {
            return "Passengers{" +
                    "no=" + no +
                    ", booking_status='" + booking_status + '\'' +
                    ", current_status='" + current_status + '\'' +
                    ", coach_position=" + coach_position +
                    '}';
        }

        private String toJsonString() {
            return "No.:" + no +
                    " Booking_status:" + booking_status + ' ' +
                    " Current_status:" + current_status + ' ' +
                    " Coach_position:" + coach_position;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getBooking_status() {
            return booking_status;
        }

        public void setBooking_status(String booking_status) {
            this.booking_status = booking_status;
        }

        public String getCurrent_status() {
            return current_status;
        }

        public void setCurrent_status(String current_status) {
            this.current_status = current_status;
        }

        public int getCoach_position() {
            return coach_position;
        }

        public void setCoach_position(int coach_position) {
            this.coach_position = coach_position;
        }
    }
}
