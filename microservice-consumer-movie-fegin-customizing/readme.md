# microservice-consumer-movie-fegin-customizing


 因为 fegin 默认使用的契约是SpringMvcContract 
 所以在UserClient中我们可以使用MVC自带的注解 eg: @GetMapping etc.
 但是此时我们自定义了fegin的Constract为fegin原生默认契约 
 因此在UserClient中,我们需要使用fegin自带的注解 eg: @RequestLine @Param etc.
