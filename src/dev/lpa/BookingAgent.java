package dev.lpa;


    public class BookingAgent {
        public static void main(String[] args) {

            int rows = 10;
            int totalSeats = 100;
            Theater rodgersNYC = new Theater("Richard Rodgers", rows, totalSeats);
            rodgersNYC.printSeatMap();

            bookSeat(rodgersNYC, 'A', 3);
            bookSeat(rodgersNYC, 'B', 1);

            bookSeats(rodgersNYC, 4, 'B', 3, 10);

        }

        private static void bookSeat(Theater theatre, char row, int seatNo){

            String seat = theatre.reserveSeat(row, seatNo);
            if (seat != null){
                System.out.println("Congratulations! Your reserved seat is " + seat);
                theatre.printSeatMap();
            }else {
                System.out.println("Sorry! Unable to reserve" + row + seatNo);
            }
        }

        private static void bookSeats(Theater theatre, int tickets, char minRow,
                                      int minSeat, int maxSeat){
            bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
        }
        private static void bookSeats(Theater theatre, int tickets,
                                      char minRow, char maxRow,
                                      int minSeat, int maxSeat){
            var seats = theatre.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
            if (seats != null){
                System.out.println("Congratulations! Your reserved seats are " + seats);
                theatre.printSeatMap();
            }else {
                System.out.println("Sorry! No matching contiguous seats in rows : "
                        + minRow + "-" + maxRow);
            }
        }
    }


