

```cpp
#include <QApplication>
#include <QMainWindow>
#include <QPushButton>
#include <QTextEdit>
#include <QVBoxLayout>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>

class MainWindow : public QMainWindow {
    Q_OBJECT

public:
    MainWindow() {
        QWidget *central = new QWidget(this);
        QVBoxLayout *layout = new QVBoxLayout(central);

        QPushButton *button = new QPushButton("Télécharger page", this);
        textEdit = new QTextEdit(this);
        layout->addWidget(button);
        layout->addWidget(textEdit);

        setCentralWidget(central);

        http = new QNetworkAccessManager(this);
        connect(button, &QPushButton::clicked, this, &MainWindow::startDownload);
        connect(http, &QNetworkAccessManager::finished, this, &MainWindow::httpDone);
    }

public slots:
    void startDownload() {
        QUrl url("http://example.com/");
        QNetworkRequest request(url);
        http->get(request);
    }

    void httpDone(QNetworkReply *reply) {
        if (reply->error() == QNetworkReply::NoError) {
            QByteArray data = reply->readAll();
            textEdit->setPlainText(data);
        } else {
            textEdit->setPlainText("Erreur lors du téléchargement.");
        }
        reply->deleteLater();
    }

private:
    QNetworkAccessManager *http;
    QTextEdit *textEdit;
};

int main(int argc, char *argv[]) {
    QApplication app(argc, argv);

    MainWindow *window = new MainWindow;
    window->show();

    return app.exec();
}
```