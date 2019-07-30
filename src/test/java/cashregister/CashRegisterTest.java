package cashregister;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Printer printer = Mockito.mock(Printer.class);
        printer.print("A\t123\n");
        CashRegister cashRegister = new CashRegister(printer);
        Item[] items = new Item[]{new Item("A", 123)};
        Purchase purchase = new Purchase(items);

        //when
        cashRegister.process(purchase);

        //then
        Mockito.verify(printer, times(1)).print("A\t123\n");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer printer = Mockito.mock(Printer.class);
        printer.print("A\t123\n");
        CashRegister cashRegister = new CashRegister(printer);
        Item[] items = new Item[]{new Item("A", 123)};
        Purchase purchase = Mockito.mock(Purchase.class);

        //when
        cashRegister.process(purchase);

        //then
        Mockito.verify(printer, times(1)).print("A\t123\n");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        //when
        //then
    }
}
