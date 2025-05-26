

```cpp
#include <QApplication>
#include <QFile>
#include <QWidget>
#include <QtUiTools/QUiLoader>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    QUiLoader loader;
    QFile file("chatlog.ui"); 

    if (!file.open(QFile::ReadOnly)) {
        qWarning("Impossible d'ouvrir le fichier UI.");
        return -1;
    }

    QWidget *widget = loader.load(&file);
    file.close();

    if (!widget) {
        qWarning("Échec du chargement de l'interface.");
        return -1;
    }

    widget->show();
    return app.exec();
}
```