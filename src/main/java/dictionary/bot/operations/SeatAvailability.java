package dictionary.bot.operations;

import com.google.gson.annotations.SerializedName;
import dictionary.bot.OutputBody;

import java.util.List;

/**
 * Created by harshit on 25/1/16.
 * Sample response
 * {
 "response_code": 200,
 "train_number": "12001",
 "train_name": "NDLS SHATABDI E",
 "error": false,
 "from": {
 "lat": 23.2599333,
 "name": "BHOPAL  JN",
 "lng": 77.412615,
 "code": "BPL"
 },
 "class": {
 "class_name": "AC CHAIR CAR",
 "class_code": "CC"
 },
 "to": {
 "lat": 30.6016778,
 "name": "NEW DELHI",
 "lng": -98.3488272,
 "code": "NDLS"
 },
 "availability": [
 {
 "date": "14-10-2014",
 "status": "AVAILABLE 364"
 },
 {
 "date": "15-10-2014",
 "status": "AVAILABLE 361"
 },
 {
 "date": "16-10-2014",
 "status": "AVAILABLE 284"
 },
 {
 "date": "17-10-2014",
 "status": "AVAILABLE 351"
 },
 {
 "date": "18-10-2014",
 "status": "AVAILABLE 303"
 },
 {
 "date": "19-10-2014",
 "status": "AVAILABLE 329"
 }
 ],
 "quota": {
 "quota_name": "GENERAL QUOTA",
 "quota_code": "GN"
 }
 }
 */
public class SeatAvailability implements OutputBody {
    private String train_number;
    private String train_name;
    private Station from;
    private Station to;
    private List<Availability> availability;
    private Quota quota;
    @SerializedName("class")
    private SeatClass seatClass;

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public Station getFrom() {
        return from;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public Station getTo() {
        return to;
    }

    public void setTo(Station to) {
        this.to = to;
    }

    public List<Availability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    @Override
    public String toString() {
        return "SeatAvailability{" +
                "train_number='" + train_number + '\'' +
                ", train_name='" + train_name + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", availability=" + availability +
                ", quota=" + quota +
                ", seatClass=" + seatClass +
                '}';
    }

    @Override
    public String toUserString() {
        return toString();
    }


    private class Station {
        private String code;
        private String name;

        @Override
        public String toString() {
            return "Station{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private class SeatClass {
        private String class_name;
        private String class_code;

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getClass_code() {
            return class_code;
        }

        public void setClass_code(String class_code) {
            this.class_code = class_code;
        }

        @Override
        public String toString() {
            return "SeatClass{" +
                    "class_name='" + class_name + '\'' +
                    ", class_code='" + class_code + '\'' +
                    '}';
        }
    }

    private class Availability {
        private String date;
        private String status;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Availability{" +
                    "date='" + date + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    private class Quota {
        private String quota_name;
        private String quota_code;

        public String getQuota_name() {
            return quota_name;
        }

        public void setQuota_name(String quota_name) {
            this.quota_name = quota_name;
        }

        public String getQuota_code() {
            return quota_code;
        }

        public void setQuota_code(String quota_code) {
            this.quota_code = quota_code;
        }

        @Override
        public String toString() {
            return "Quota{" +
                    "quota_name='" + quota_name + '\'' +
                    ", quota_code='" + quota_code + '\'' +
                    '}';
        }
    }
}
