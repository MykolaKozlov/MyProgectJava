package SevenLesson.Chapter_2_Task_2;

public class ServiceLauncher {
    public static void main(String[] args) {
        ServiceRepository<Service> serviceServiceRepository = new ServiceRepository<>();
        serviceServiceRepository.add(new Test());
//        serviceServiceRepository.add(new TestNotService());
    }
}
