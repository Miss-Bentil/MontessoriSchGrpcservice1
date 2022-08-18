package montessori.school.grpcservice;


import com.grpcdemo.Project;
import com.grpcdemo.ProjectStudentServiceGrpc;
import com.grpcdemo.Student;
import io.grpc.stub.StreamObserver;
import montessori.school.proto.TempDB;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProjectStudentServerService extends ProjectStudentServiceGrpc.ProjectStudentServiceImplBase {

    @Override
    public void getStudent(Student request, StreamObserver<Student> responseObserver) {
        TempDB.getStudentsFromTempDb()
                .stream()
                .filter(author -> author.getStudentId() == request.getStudentId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }







}
