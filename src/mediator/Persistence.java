package mediator;

import java.io.File;

public interface Persistence
{
   void save(File file, Object object);
   Object update(File file);
   Object delete(File file, Object object);
}
