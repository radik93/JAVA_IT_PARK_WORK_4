package ru.itpark.app.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.app.models.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
  FileInfo findOneByStorageFileName(String fileName);
}
