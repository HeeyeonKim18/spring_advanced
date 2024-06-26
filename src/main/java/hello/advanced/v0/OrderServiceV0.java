package hello.advanced.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRepositoryV0 orderRepository;

    public void orderItem(String itemId) throws InterruptedException, IllegalAccessException {
        orderRepository.save(itemId);
    }
}
